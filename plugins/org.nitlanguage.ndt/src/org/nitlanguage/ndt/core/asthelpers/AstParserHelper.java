package org.nitlanguage.ndt.core.asthelpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.util.ArrayList;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.nitlanguage.gen.lexer.Lexer;
import org.nitlanguage.gen.lexer.LexerException;
import org.nitlanguage.gen.node.AAttrPropdef;
import org.nitlanguage.gen.node.AConcreteInitPropdef;
import org.nitlanguage.gen.node.AConcreteMethPropdef;
import org.nitlanguage.gen.node.ADeferredMethPropdef;
import org.nitlanguage.gen.node.AModule;
import org.nitlanguage.gen.node.AModuleName;
import org.nitlanguage.gen.node.AModuledecl;
import org.nitlanguage.gen.node.AStdClassdef;
import org.nitlanguage.gen.node.AStdImport;
import org.nitlanguage.gen.node.ATopClassdef;
import org.nitlanguage.gen.node.PClassdef;
import org.nitlanguage.gen.node.PImport;
import org.nitlanguage.gen.node.PPropdef;
import org.nitlanguage.gen.node.Start;
import org.nitlanguage.gen.parser.Parser;
import org.nitlanguage.gen.parser.ParserException;
import org.nitlanguage.ndt.core.PluginParams;
import org.nitlanguage.ndt.core.StringArrayHelp;
import org.nitlanguage.ndt.core.builder.NitNature;
import org.nitlanguage.ndt.core.plugin.NitActivator;
import org.nitlanguage.ndt.ui.editor.DocumentBufferStream;

/**
 * Class used to simplify the treatments on the AST generated by 
 * the Nit Parser
 * @author lucas.bajolet
 */
public class AstParserHelper {

	public AstParserHelper() {
	}

	/**
	 * Gets the AST Start node of a Document if the parsing succeeds or if the
	 * document had been parsed before. Returns null otherwise
	 * 
	 * @param A
	 *            IDocument to parse or get the AST in the reposit
	 * @return A Start node
	 */
	public Start getAstForDocument(IDocument document) {
		if (document != null) {
			DocumentBufferStream dbs = new DocumentBufferStream();

			dbs.setDoc(document);

			Lexer lex = this.getLexForSource(dbs);
			if (lex != null) {
				Start node = getAstForDocumentBody(lex);
				if (node != null) {
					this.saveStartNodeInAST(node, document);
					return node;
				}
			}
			return null;
		} else {
			return null;
		}
	}

	/**
	 * Gets the AST Start node of a Document if the parsing succeeds or if the
	 * document had been parsed before.
	 * 
	 * @param file
	 *            The IFile to parse
	 * @return A Start node if found or null otherwise
	 */
	public Start getAstForDocument(IFile file) {

		Lexer lex = getLexForSource(file);

		if (lex != null) {
			Start node = this.getAstForDocumentBody(lex);
			if (node != null) {
				this.saveStartNodeInAST(node, file);
				return node;
			}
		}
		return null;
	}

	/**
	 * Gets the AST Start node of an import node if the parsing succeeds or if
	 * the document had been parsed before. Returns null otherwise
	 * 
	 * @param imp
	 *            The import node
	 * @param fileToSeekFrom
	 *            The file needed to simulate the import mechanism
	 * @return A Start node if found or null otherwise
	 */
	public Start getAstForDocument(AStdImport imp, IFile fileToSeekFrom) {
		// Get IFile for this import
		AModuleName moduleName = (AModuleName) imp.getName();
		String mod = moduleName.toString();

		String fullPathInOS = fileToSeekFrom.getLocation().toString();

		String[] separatedPath = fullPathInOS.split("/");

		StringArrayHelp sah = new StringArrayHelp();

		while (separatedPath.length > 1) {
			separatedPath[separatedPath.length - 1] = mod.trim();

			// Check if a file with .nit extension exists, else, try to find a
			// directory with that name and get the file bearing this name in
			// that directory if there is
			File toCheck = new File(sah.join(separatedPath, "/") + PluginParams.NIT_EXTENSION);

			if (toCheck.exists() && toCheck.isFile()) {
				Start node = this.getAstForDocumentBody(this
						.getLexForSource(toCheck));
				try {
					saveStartNodeInAST(
							node,
							toCheck,
							(NitNature) fileToSeekFrom.getProject().getNature(
									PluginParams.NATURE_ID));
				} catch (CoreException e) {
					if (NitActivator.DEBUG_MODE)
						e.printStackTrace();
				}
				return node;
			} else {
				File dir = new File(sah.join(separatedPath, "/"));
				if (dir.exists() && dir.isDirectory()) {
					File finalFile = new File(sah.join(separatedPath, "/")
							+ "/" + separatedPath[separatedPath.length - 1]
							+ PluginParams.NIT_EXTENSION);

					if (finalFile.exists() && finalFile.isFile()) {
						Start node = this.getAstForDocumentBody(this
								.getLexForSource(finalFile));
						if (node != null)
							try {
								saveStartNodeInAST(node, finalFile,
										(NitNature) fileToSeekFrom.getProject()
												.getNature(PluginParams.NATURE_ID));
							} catch (CoreException e) {
								if (NitActivator.DEBUG_MODE)
									e.printStackTrace();
							}
						return node;
					}
				}
			}

			// Remove the last
			separatedPath = sah.removeLast(separatedPath);
		}

		return null;
	}

	/**
	 * Saves a Start node in the AST for the IFile given
	 * 
	 * @param node
	 *            The node to save into the ASTReposit for the actual project
	 * @param fileBound
	 *            The file bound to the node, used to get the name
	 */
	private void saveStartNodeInAST(Start node, IFile fileBound) {
		try {
			((NitNature) fileBound.getProject().getNature(PluginParams.NATURE_ID))
					.getAstReposit().addOrReplaceAST(fileBound.getName(), node);
		} catch (Exception e) {
			if (NitActivator.DEBUG_MODE)
				e.printStackTrace();
		}
	}

	/**
	 * Saves a Start node in the AST for the IDocument given
	 * @param node The node to save into the ASTReposit for the actual project
	 * @param fileBound
	 *            The document bound to the node, used to get the name, project
	 *            and save into the reposit
	 */
	private void saveStartNodeInAST(Start node, IDocument fileBound) {
		AModuledecl docName;
		
		try {
			docName = (AModuledecl) this.getModuleOfAST(node)
					.getModuledecl();
			String modName = docName.getName().toString();
			// Get open editors
			for (IEditorReference editor : PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getEditorReferences()) {
				if (editor.getEditorInput() instanceof FileEditorInput) {
					FileEditorInput fed = (FileEditorInput) editor
							.getEditorInput();
					String fileName = fed.getFile().getName();
					if (fileName.equals(modName.trim() + PluginParams.NIT_EXTENSION)) {
						NitNature nnat = (NitNature) fed.getFile().getProject()
								.getNature(PluginParams.NATURE_ID);
						nnat.getAstReposit().addOrReplaceAST(fileName, node);
						break;
					}
				}
			}
		} catch (PartInitException e) {
			if (NitActivator.DEBUG_MODE)
				e.printStackTrace();
		} catch (CoreException e) {
			if (NitActivator.DEBUG_MODE)
				e.printStackTrace();
		} catch (Exception e) {
			
		}
	}

	/**
	 * Saves a Start node in the AST for the File given
	 * 
	 * @param node
	 *            The node to save into the ASTReposit for the actual project
	 * @param fileBound
	 *            The File bound to the Start node
	 * @param natureConcerned
	 *            Nature concerned by the node, to save in the AST Reposit of
	 *            the good project
	 */
	private void saveStartNodeInAST(Start node, File fileBound,
			NitNature natureConcerned) {
		String fileName = fileBound.getName();
		try {
			natureConcerned.getAstReposit().addOrReplaceAST(fileName, node);
		} catch (Exception e) {
			if (NitActivator.DEBUG_MODE)
				e.printStackTrace();
		}
	}

	/**
	 * Gets the AST for specified Lexer
	 * 
	 * @param lex
	 *            Lexer for a file
	 * @return Start node if parsed or null otherwise
	 */
	private Start getAstForDocumentBody(Lexer lex) {

		Parser pp = new Parser(lex);

		NitNature nnat = null;

		Start st = null;
		try {
			st = pp.parse();
		} catch (ParserException e) {
			if (NitActivator.DEBUG_MODE)
				e.printStackTrace();
		} catch (LexerException e) {
			if (NitActivator.DEBUG_MODE)
				e.printStackTrace();
		} catch (IOException e) {
			if (NitActivator.DEBUG_MODE)
				e.printStackTrace();
		}

		IFile fileBoundToIDocument = null;
		// First get the active editor, if nit editor, get the file bound to the
		// IDocument
		try {
			IEditorInput ie = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor().getEditorInput();
			if (ie instanceof FileEditorInput) {
				fileBoundToIDocument = ((FileEditorInput) ie).getFile();
			}

			try {
				nnat = (NitNature) fileBoundToIDocument.getProject().getNature(
						PluginParams.NATURE_ID);
				nnat.getProjectAutoParser().addToQueue(fileBoundToIDocument);
			} catch (Exception e) {
				if (NitActivator.DEBUG_MODE)
					e.printStackTrace();
			}
		} catch (Exception e) {
			if (NitActivator.DEBUG_MODE)
				e.printStackTrace();
		}

		if (st == null) {
			System.out.println("Parsing has failed");
			// If st is null, the parsing has failed, for whatever reason
			// (Parser/Lexer Exception or IO error)
			// Therefore, call the compiler to find the error spot and have it
			// pop up in the editor
			// This is done in the ProjectAutoParser class

			// Try to get and old version of the Start node anyway in the node
			// reposit of the project
			if (nnat != null) {
				return nnat.getAstReposit().getAST(
						fileBoundToIDocument.getName());
			}
			return null;
		} else {
			return st;
		}
	}

	/**
	 * Gets a Lexer instance for a DocumentBufferStream instance
	 * 
	 * @param dbs
	 *            DocumentBufferStream used to parse a file
	 * @return The Lexer instance corresponding to the DocumentBufferStream
	 */
	private Lexer getLexForSource(DocumentBufferStream dbs) {
		dbs.reset();

		return new Lexer(new PushbackReader(dbs, 2));
	}

	/**
	 * Gets a lexer instance for a source IFile
	 * 
	 * @param file
	 *            The IFile used to get the Lexer instance
	 * @return The Lexer instance
	 */
	private Lexer getLexForSource(IFile file) {
		PushbackReader pbr = null;
		try {
			Path test_path = new Path(NitActivator.getWorkspacePath().toOSString() + file.getFullPath().toString());
			FileReader fr = new FileReader(test_path.toFile());
			pbr = new PushbackReader(fr, 2);
		} catch (FileNotFoundException e1) {
			if (NitActivator.DEBUG_MODE) e1.printStackTrace();
		}
		if (pbr != null) {
			return new Lexer(pbr);
		}
		return null;
	}

	/**
	 * Get a lexer instance for a Source File
	 * 
	 * @param file
	 *            The File used to get a Lexer Instance
	 * @return The Lexer instance
	 */
	private Lexer getLexForSource(File file) {
		Lexer lex = null;
		if (file.exists()) {
			try {
				lex = new Lexer(new PushbackReader(new FileReader(file)));
			} catch (FileNotFoundException e) {
				if (NitActivator.DEBUG_MODE)
					e.printStackTrace();
			}
		}
		return lex;
	}

	/**
	 * Gets the module node of a nit document in the AST corresponding to the
	 * document
	 * 
	 * @param Start
	 *            node of an AST generated by the Nit Parser
	 * @return A module node
	 * @throws Exception 
	 */
	public AModule getModuleOfAST(Start startNode) throws Exception {

		if(startNode == null){
			throw new Exception("Try to get module from an unset node");
		}
		if (startNode.getPModule() instanceof AModule) {
			return (AModule) startNode.getPModule();
		}
		return null;

	}

	/**
	 * Gets the classes of a Module node
	 * 
	 * @param Module
	 *            node
	 * @return An ArrayList of class nodes, ready to be used
	 */
	public ArrayList<AStdClassdef> getAStdClassesOfModule(AModule module) {
		ArrayList<AStdClassdef> defs = new ArrayList<AStdClassdef>();
		for (PClassdef pclass : module.getClassdefs()) {
			if (pclass instanceof AStdClassdef) {
				AStdClassdef amc = (AStdClassdef) pclass;
				defs.add(amc);
			}
		}
		return defs;
	}

	/**
	 * Gets the Top Classes Definitions of a Module
	 * 
	 * @param module The module to get top level classes into
	 * @return An ArrayList of Top classes definitions
	 */
	public ArrayList<ATopClassdef> getATopClassesOfModule(AModule module) {

		ArrayList<ATopClassdef> defs = new ArrayList<ATopClassdef>();

		for (PClassdef pclass : module.getClassdefs()) {

			if (pclass instanceof ATopClassdef) {
				ATopClassdef amc = (ATopClassdef) pclass;
				defs.add(amc);
			}
		}

		return defs;
	}

	/**
	 * Gets all the import nodes of a Module node
	 * 
	 * @param Module
	 *            node
	 * @return List of imports
	 */
	public ArrayList<AStdImport> getImports(AModule module) {

		ArrayList<AStdImport> results = new ArrayList<AStdImport>();
		LinkedList<PImport> pi = module.getImports();

		for (PImport pim : pi) {
			if (pim instanceof AStdImport) {
				results.add((AStdImport) pim);
			}
		}

		return results;
	}

	/**
	 * Gets the propdefs of a Class node
	 * 
	 * @param Class
	 *            definition node
	 * @return List of propdefs
	 */
	public LinkedList<PPropdef> getPropsOfClass(AStdClassdef className) {

		LinkedList<PPropdef> props = className.getPropdefs();

		return props;
	}

	/**
	 * Gets the concrete methods definitions in the props list
	 * 
	 * @param Properties
	 *            got from the getPropsOfClass
	 * @return List of concrete method definitions
	 */
	public ArrayList<AConcreteMethPropdef> getConcreteMethsInPropList(
			LinkedList<PPropdef> props) {
		ArrayList<AConcreteMethPropdef> methods = new ArrayList<AConcreteMethPropdef>();

		for (PPropdef prp : props) {
			if (prp instanceof AConcreteMethPropdef) {
				methods.add((AConcreteMethPropdef) prp);
			}
		}

		return methods;
	}

	/**
	 * Gets the deferred methods definitions (external definitions) in the props
	 * list
	 * 
	 * @param Properties got from the getPropsOfClass
	 * @return List of deferred method definitions
	 */
	public ArrayList<ADeferredMethPropdef> getDeferredMethsInPropList(
			LinkedList<PPropdef> props) {
		ArrayList<ADeferredMethPropdef> methods = new ArrayList<ADeferredMethPropdef>();

		for (PPropdef prp : props) {
			if (prp instanceof ADeferredMethPropdef) {
				methods.add((ADeferredMethPropdef) prp);
			}
		}

		return methods;
	}

	/**
	 * Gets the attributes in the props list
	 * 
	 * @param Properties
	 *            got from the getPropsOfClass
	 * @return List of attributes
	 */
	public ArrayList<AAttrPropdef> getNonMethPropsInPropList(LinkedList<PPropdef> props) {
		ArrayList<AAttrPropdef> nonMethProps = new ArrayList<AAttrPropdef>();
		for (PPropdef prp : props) {
			if (prp instanceof AAttrPropdef) {
				nonMethProps.add((AAttrPropdef) prp);
			}
		}
		return nonMethProps;
	}

	/**
	 * Gets the init_ blocks
	 * 
	 * @param Properties
	 *            got from the getPropsOfClass
	 * @return List of construct methods found in the props list
	 */
	public ArrayList<AConcreteInitPropdef> getConstructMethsInPropList(
			LinkedList<PPropdef> props) {
		ArrayList<AConcreteInitPropdef> constructs = new ArrayList<AConcreteInitPropdef>();

		for (PPropdef prp : props) {
			if (prp instanceof AConcreteInitPropdef) {
				constructs.add((AConcreteInitPropdef) prp);
			}
		}

		return constructs;
	}
}
