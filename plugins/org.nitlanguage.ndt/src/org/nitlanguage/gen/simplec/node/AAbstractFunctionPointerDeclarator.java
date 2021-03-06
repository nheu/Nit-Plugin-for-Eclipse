/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import java.util.*;
import org.nitlanguage.gen.simplec.analysis.*;

public final class AAbstractFunctionPointerDeclarator extends PAbstractFunctionPointerDeclarator
{
    private TLPar _plp_;
    private PAbstractPointer _abstractPointer_;
    private TRPar _prp_;
    private TLPar _pllp_;
    private PParameterList _parameterList_;
    private TRPar _plrp_;

    public AAbstractFunctionPointerDeclarator()
    {
    }

    public AAbstractFunctionPointerDeclarator(
        TLPar _plp_,
        PAbstractPointer _abstractPointer_,
        TRPar _prp_,
        TLPar _pllp_,
        PParameterList _parameterList_,
        TRPar _plrp_)
    {
        setPlp(_plp_);

        setAbstractPointer(_abstractPointer_);

        setPrp(_prp_);

        setPllp(_pllp_);

        setParameterList(_parameterList_);

        setPlrp(_plrp_);

    }
    public Object clone()
    {
        return new AAbstractFunctionPointerDeclarator(
            (TLPar) cloneNode(_plp_),
            (PAbstractPointer) cloneNode(_abstractPointer_),
            (TRPar) cloneNode(_prp_),
            (TLPar) cloneNode(_pllp_),
            (PParameterList) cloneNode(_parameterList_),
            (TRPar) cloneNode(_plrp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAbstractFunctionPointerDeclarator(this);
    }

    public TLPar getPlp()
    {
        return _plp_;
    }

    public void setPlp(TLPar node)
    {
        if(_plp_ != null)
        {
            _plp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _plp_ = node;
    }

    public PAbstractPointer getAbstractPointer()
    {
        return _abstractPointer_;
    }

    public void setAbstractPointer(PAbstractPointer node)
    {
        if(_abstractPointer_ != null)
        {
            _abstractPointer_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _abstractPointer_ = node;
    }

    public TRPar getPrp()
    {
        return _prp_;
    }

    public void setPrp(TRPar node)
    {
        if(_prp_ != null)
        {
            _prp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _prp_ = node;
    }

    public TLPar getPllp()
    {
        return _pllp_;
    }

    public void setPllp(TLPar node)
    {
        if(_pllp_ != null)
        {
            _pllp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pllp_ = node;
    }

    public PParameterList getParameterList()
    {
        return _parameterList_;
    }

    public void setParameterList(PParameterList node)
    {
        if(_parameterList_ != null)
        {
            _parameterList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _parameterList_ = node;
    }

    public TRPar getPlrp()
    {
        return _plrp_;
    }

    public void setPlrp(TRPar node)
    {
        if(_plrp_ != null)
        {
            _plrp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _plrp_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_plp_)
            + toString(_abstractPointer_)
            + toString(_prp_)
            + toString(_pllp_)
            + toString(_parameterList_)
            + toString(_plrp_);
    }

    void removeChild(Node child)
    {
        if(_plp_ == child)
        {
            _plp_ = null;
            return;
        }

        if(_abstractPointer_ == child)
        {
            _abstractPointer_ = null;
            return;
        }

        if(_prp_ == child)
        {
            _prp_ = null;
            return;
        }

        if(_pllp_ == child)
        {
            _pllp_ = null;
            return;
        }

        if(_parameterList_ == child)
        {
            _parameterList_ = null;
            return;
        }

        if(_plrp_ == child)
        {
            _plrp_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_plp_ == oldChild)
        {
            setPlp((TLPar) newChild);
            return;
        }

        if(_abstractPointer_ == oldChild)
        {
            setAbstractPointer((PAbstractPointer) newChild);
            return;
        }

        if(_prp_ == oldChild)
        {
            setPrp((TRPar) newChild);
            return;
        }

        if(_pllp_ == oldChild)
        {
            setPllp((TLPar) newChild);
            return;
        }

        if(_parameterList_ == oldChild)
        {
            setParameterList((PParameterList) newChild);
            return;
        }

        if(_plrp_ == oldChild)
        {
            setPlrp((TRPar) newChild);
            return;
        }

    }
}
