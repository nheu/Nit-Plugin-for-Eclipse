/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import org.nitlanguage.gen.simplec.analysis.*;

public final class X2PAdditionalEnumerator extends XPAdditionalEnumerator
{
    private PAdditionalEnumerator _pAdditionalEnumerator_;

    public X2PAdditionalEnumerator()
    {
    }

    public X2PAdditionalEnumerator(
        PAdditionalEnumerator _pAdditionalEnumerator_)
    {
        setPAdditionalEnumerator(_pAdditionalEnumerator_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public PAdditionalEnumerator getPAdditionalEnumerator()
    {
        return _pAdditionalEnumerator_;
    }

    public void setPAdditionalEnumerator(PAdditionalEnumerator node)
    {
        if(_pAdditionalEnumerator_ != null)
        {
            _pAdditionalEnumerator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pAdditionalEnumerator_ = node;
    }

    void removeChild(Node child)
    {
        if(_pAdditionalEnumerator_ == child)
        {
            _pAdditionalEnumerator_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_pAdditionalEnumerator_);
    }
}
