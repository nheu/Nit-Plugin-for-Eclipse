/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import java.util.*;
import org.nitlanguage.gen.simplec.analysis.*;

public final class AArglist extends PArglist
{
    private PValue _value_;
    private final LinkedList _arglistTail_ = new TypedLinkedList(new ArglistTail_Cast());

    public AArglist()
    {
    }

    public AArglist(
        PValue _value_,
        List _arglistTail_)
    {
        setValue(_value_);

        {
            this._arglistTail_.clear();
            this._arglistTail_.addAll(_arglistTail_);
        }

    }

    public AArglist(
        PValue _value_,
        XPArglistTail _arglistTail_)
    {
        setValue(_value_);

        if(_arglistTail_ != null)
        {
            while(_arglistTail_ instanceof X1PArglistTail)
            {
                this._arglistTail_.addFirst(((X1PArglistTail) _arglistTail_).getPArglistTail());
                _arglistTail_ = ((X1PArglistTail) _arglistTail_).getXPArglistTail();
            }
            this._arglistTail_.addFirst(((X2PArglistTail) _arglistTail_).getPArglistTail());
        }

    }
    public Object clone()
    {
        return new AArglist(
            (PValue) cloneNode(_value_),
            cloneList(_arglistTail_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArglist(this);
    }

    public PValue getValue()
    {
        return _value_;
    }

    public void setValue(PValue node)
    {
        if(_value_ != null)
        {
            _value_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _value_ = node;
    }

    public LinkedList getArglistTail()
    {
        return _arglistTail_;
    }

    public void setArglistTail(List list)
    {
        _arglistTail_.clear();
        _arglistTail_.addAll(list);
    }

    public String toString()
    {
        return ""
            + toString(_value_)
            + toString(_arglistTail_);
    }

    void removeChild(Node child)
    {
        if(_value_ == child)
        {
            _value_ = null;
            return;
        }

        if(_arglistTail_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_value_ == oldChild)
        {
            setValue((PValue) newChild);
            return;
        }

        for(ListIterator i = _arglistTail_.listIterator(); i.hasNext();)
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

    }

    private class ArglistTail_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PArglistTail node = (PArglistTail) o;

            if((node.parent() != null) &&
                (node.parent() != AArglist.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AArglist.this))
            {
                node.parent(AArglist.this);
            }

            return node;
        }
    }
}
