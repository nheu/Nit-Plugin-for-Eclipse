/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import java.util.*;
import org.nitlanguage.gen.simplec.analysis.*;

public final class AArrayAbstractDirectDeclarator extends PAbstractDirectDeclarator
{
    private PAbstractArrayDeclarator _abstractArrayDeclarator_;

    public AArrayAbstractDirectDeclarator()
    {
    }

    public AArrayAbstractDirectDeclarator(
        PAbstractArrayDeclarator _abstractArrayDeclarator_)
    {
        setAbstractArrayDeclarator(_abstractArrayDeclarator_);

    }
    public Object clone()
    {
        return new AArrayAbstractDirectDeclarator(
            (PAbstractArrayDeclarator) cloneNode(_abstractArrayDeclarator_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayAbstractDirectDeclarator(this);
    }

    public PAbstractArrayDeclarator getAbstractArrayDeclarator()
    {
        return _abstractArrayDeclarator_;
    }

    public void setAbstractArrayDeclarator(PAbstractArrayDeclarator node)
    {
        if(_abstractArrayDeclarator_ != null)
        {
            _abstractArrayDeclarator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _abstractArrayDeclarator_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_abstractArrayDeclarator_);
    }

    void removeChild(Node child)
    {
        if(_abstractArrayDeclarator_ == child)
        {
            _abstractArrayDeclarator_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_abstractArrayDeclarator_ == oldChild)
        {
            setAbstractArrayDeclarator((PAbstractArrayDeclarator) newChild);
            return;
        }

    }
}
