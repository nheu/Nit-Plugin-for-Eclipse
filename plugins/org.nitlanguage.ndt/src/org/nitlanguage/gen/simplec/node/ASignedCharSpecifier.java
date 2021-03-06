/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import java.util.*;
import org.nitlanguage.gen.simplec.analysis.*;

public final class ASignedCharSpecifier extends PSignedCharSpecifier
{
    private TSigned _signed_;
    private TChar _char_;

    public ASignedCharSpecifier()
    {
    }

    public ASignedCharSpecifier(
        TSigned _signed_,
        TChar _char_)
    {
        setSigned(_signed_);

        setChar(_char_);

    }
    public Object clone()
    {
        return new ASignedCharSpecifier(
            (TSigned) cloneNode(_signed_),
            (TChar) cloneNode(_char_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASignedCharSpecifier(this);
    }

    public TSigned getSigned()
    {
        return _signed_;
    }

    public void setSigned(TSigned node)
    {
        if(_signed_ != null)
        {
            _signed_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _signed_ = node;
    }

    public TChar getChar()
    {
        return _char_;
    }

    public void setChar(TChar node)
    {
        if(_char_ != null)
        {
            _char_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _char_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_signed_)
            + toString(_char_);
    }

    void removeChild(Node child)
    {
        if(_signed_ == child)
        {
            _signed_ = null;
            return;
        }

        if(_char_ == child)
        {
            _char_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_signed_ == oldChild)
        {
            setSigned((TSigned) newChild);
            return;
        }

        if(_char_ == oldChild)
        {
            setChar((TChar) newChild);
            return;
        }

    }
}
