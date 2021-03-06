/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import java.util.*;
import org.nitlanguage.gen.simplec.analysis.*;

public final class AFunctionBody extends PFunctionBody
{
    private TLBrace _lBrace_;
    private final LinkedList _variableDeclaration_ = new TypedLinkedList(new VariableDeclaration_Cast());
    private final LinkedList _statement_ = new TypedLinkedList(new Statement_Cast());
    private PStopStatement _stopStatement_;
    private TRBrace _rBrace_;

    public AFunctionBody()
    {
    }

    public AFunctionBody(
        TLBrace _lBrace_,
        List _variableDeclaration_,
        List _statement_,
        PStopStatement _stopStatement_,
        TRBrace _rBrace_)
    {
        setLBrace(_lBrace_);

        {
            this._variableDeclaration_.clear();
            this._variableDeclaration_.addAll(_variableDeclaration_);
        }

        {
            this._statement_.clear();
            this._statement_.addAll(_statement_);
        }

        setStopStatement(_stopStatement_);

        setRBrace(_rBrace_);

    }

    public AFunctionBody(
        TLBrace _lBrace_,
        XPVariableDeclaration _variableDeclaration_,
        XPStatement _statement_,
        PStopStatement _stopStatement_,
        TRBrace _rBrace_)
    {
        setLBrace(_lBrace_);

        if(_variableDeclaration_ != null)
        {
            while(_variableDeclaration_ instanceof X1PVariableDeclaration)
            {
                this._variableDeclaration_.addFirst(((X1PVariableDeclaration) _variableDeclaration_).getPVariableDeclaration());
                _variableDeclaration_ = ((X1PVariableDeclaration) _variableDeclaration_).getXPVariableDeclaration();
            }
            this._variableDeclaration_.addFirst(((X2PVariableDeclaration) _variableDeclaration_).getPVariableDeclaration());
        }

        if(_statement_ != null)
        {
            while(_statement_ instanceof X1PStatement)
            {
                this._statement_.addFirst(((X1PStatement) _statement_).getPStatement());
                _statement_ = ((X1PStatement) _statement_).getXPStatement();
            }
            this._statement_.addFirst(((X2PStatement) _statement_).getPStatement());
        }

        setStopStatement(_stopStatement_);

        setRBrace(_rBrace_);

    }
    public Object clone()
    {
        return new AFunctionBody(
            (TLBrace) cloneNode(_lBrace_),
            cloneList(_variableDeclaration_),
            cloneList(_statement_),
            (PStopStatement) cloneNode(_stopStatement_),
            (TRBrace) cloneNode(_rBrace_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFunctionBody(this);
    }

    public TLBrace getLBrace()
    {
        return _lBrace_;
    }

    public void setLBrace(TLBrace node)
    {
        if(_lBrace_ != null)
        {
            _lBrace_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lBrace_ = node;
    }

    public LinkedList getVariableDeclaration()
    {
        return _variableDeclaration_;
    }

    public void setVariableDeclaration(List list)
    {
        _variableDeclaration_.clear();
        _variableDeclaration_.addAll(list);
    }

    public LinkedList getStatement()
    {
        return _statement_;
    }

    public void setStatement(List list)
    {
        _statement_.clear();
        _statement_.addAll(list);
    }

    public PStopStatement getStopStatement()
    {
        return _stopStatement_;
    }

    public void setStopStatement(PStopStatement node)
    {
        if(_stopStatement_ != null)
        {
            _stopStatement_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _stopStatement_ = node;
    }

    public TRBrace getRBrace()
    {
        return _rBrace_;
    }

    public void setRBrace(TRBrace node)
    {
        if(_rBrace_ != null)
        {
            _rBrace_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rBrace_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_lBrace_)
            + toString(_variableDeclaration_)
            + toString(_statement_)
            + toString(_stopStatement_)
            + toString(_rBrace_);
    }

    void removeChild(Node child)
    {
        if(_lBrace_ == child)
        {
            _lBrace_ = null;
            return;
        }

        if(_variableDeclaration_.remove(child))
        {
            return;
        }

        if(_statement_.remove(child))
        {
            return;
        }

        if(_stopStatement_ == child)
        {
            _stopStatement_ = null;
            return;
        }

        if(_rBrace_ == child)
        {
            _rBrace_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_lBrace_ == oldChild)
        {
            setLBrace((TLBrace) newChild);
            return;
        }

        for(ListIterator i = _variableDeclaration_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        for(ListIterator i = _statement_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(_stopStatement_ == oldChild)
        {
            setStopStatement((PStopStatement) newChild);
            return;
        }

        if(_rBrace_ == oldChild)
        {
            setRBrace((TRBrace) newChild);
            return;
        }

    }

    private class VariableDeclaration_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PVariableDeclaration node = (PVariableDeclaration) o;

            if((node.parent() != null) &&
                (node.parent() != AFunctionBody.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AFunctionBody.this))
            {
                node.parent(AFunctionBody.this);
            }

            return node;
        }
    }

    private class Statement_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PStatement node = (PStatement) o;

            if((node.parent() != null) &&
                (node.parent() != AFunctionBody.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AFunctionBody.this))
            {
                node.parent(AFunctionBody.this);
            }

            return node;
        }
    }
}
