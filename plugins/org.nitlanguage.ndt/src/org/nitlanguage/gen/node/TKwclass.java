/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.node;

import org.nitlanguage.gen.analysis.Analysis;

@SuppressWarnings("nls")
public final class TKwclass extends Token
{
    public TKwclass()
    {
        super.setText("class");
    }

    public TKwclass(int line, int pos)
    {
        super.setText("class");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TKwclass(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKwclass(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKwclass text.");
    }
}
