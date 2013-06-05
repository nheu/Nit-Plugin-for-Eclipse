/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import java.util.*;
import org.nitlanguage.gen.simplec.analysis.*;

public final class ARelopBinop extends PBinop
{
    private PRelop _relop_;

    public ARelopBinop()
    {
    }

    public ARelopBinop(
        PRelop _relop_)
    {
        setRelop(_relop_);

    }
    public Object clone()
    {
        return new ARelopBinop(
            (PRelop) cloneNode(_relop_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARelopBinop(this);
    }

    public PRelop getRelop()
    {
        return _relop_;
    }

    public void setRelop(PRelop node)
    {
        if(_relop_ != null)
        {
            _relop_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _relop_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_relop_);
    }

    void removeChild(Node child)
    {
        if(_relop_ == child)
        {
            _relop_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_relop_ == oldChild)
        {
            setRelop((PRelop) newChild);
            return;
        }

    }
}