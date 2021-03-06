/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.node;

import org.nitlanguage.gen.analysis.Analysis;

@SuppressWarnings("nls")
public final class TKwtype extends Token
{
    public TKwtype()
    {
        super.setText("type");
    }

    public TKwtype(int line, int pos)
    {
        super.setText("type");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TKwtype(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKwtype(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKwtype text.");
    }
}
