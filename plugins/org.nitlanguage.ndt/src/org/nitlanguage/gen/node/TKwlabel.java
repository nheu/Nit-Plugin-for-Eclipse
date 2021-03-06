/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.node;

import org.nitlanguage.gen.analysis.Analysis;

@SuppressWarnings("nls")
public final class TKwlabel extends Token
{
    public TKwlabel()
    {
        super.setText("label");
    }

    public TKwlabel(int line, int pos)
    {
        super.setText("label");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TKwlabel(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKwlabel(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKwlabel text.");
    }
}
