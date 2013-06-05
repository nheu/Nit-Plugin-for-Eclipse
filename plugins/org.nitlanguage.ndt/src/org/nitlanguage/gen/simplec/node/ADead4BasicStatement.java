/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import java.util.*;
import org.nitlanguage.gen.simplec.analysis.*;

public final class ADead4BasicStatement extends PBasicStatement
{
    private PUnop _unop_;
    private TIdentifier _identifier_;

    public ADead4BasicStatement()
    {
    }

    public ADead4BasicStatement(
        PUnop _unop_,
        TIdentifier _identifier_)
    {
        setUnop(_unop_);

        setIdentifier(_identifier_);

    }
    public Object clone()
    {
        return new ADead4BasicStatement(
            (PUnop) cloneNode(_unop_),
            (TIdentifier) cloneNode(_identifier_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADead4BasicStatement(this);
    }

    public PUnop getUnop()
    {
        return _unop_;
    }

    public void setUnop(PUnop node)
    {
        if(_unop_ != null)
        {
            _unop_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _unop_ = node;
    }

    public TIdentifier getIdentifier()
    {
        return _identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(_identifier_ != null)
        {
            _identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _identifier_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_unop_)
            + toString(_identifier_);
    }

    void removeChild(Node child)
    {
        if(_unop_ == child)
        {
            _unop_ = null;
            return;
        }

        if(_identifier_ == child)
        {
            _identifier_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_unop_ == oldChild)
        {
            setUnop((PUnop) newChild);
            return;
        }

        if(_identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

    }
}