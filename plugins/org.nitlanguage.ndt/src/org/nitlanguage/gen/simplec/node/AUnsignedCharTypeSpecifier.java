/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import java.util.*;
import org.nitlanguage.gen.simplec.analysis.*;

public final class AUnsignedCharTypeSpecifier extends PTypeSpecifier
{
    private PUnsignedCharSpecifier _unsignedCharSpecifier_;

    public AUnsignedCharTypeSpecifier()
    {
    }

    public AUnsignedCharTypeSpecifier(
        PUnsignedCharSpecifier _unsignedCharSpecifier_)
    {
        setUnsignedCharSpecifier(_unsignedCharSpecifier_);

    }
    public Object clone()
    {
        return new AUnsignedCharTypeSpecifier(
            (PUnsignedCharSpecifier) cloneNode(_unsignedCharSpecifier_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAUnsignedCharTypeSpecifier(this);
    }

    public PUnsignedCharSpecifier getUnsignedCharSpecifier()
    {
        return _unsignedCharSpecifier_;
    }

    public void setUnsignedCharSpecifier(PUnsignedCharSpecifier node)
    {
        if(_unsignedCharSpecifier_ != null)
        {
            _unsignedCharSpecifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _unsignedCharSpecifier_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_unsignedCharSpecifier_);
    }

    void removeChild(Node child)
    {
        if(_unsignedCharSpecifier_ == child)
        {
            _unsignedCharSpecifier_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_unsignedCharSpecifier_ == oldChild)
        {
            setUnsignedCharSpecifier((PUnsignedCharSpecifier) newChild);
            return;
        }

    }
}
