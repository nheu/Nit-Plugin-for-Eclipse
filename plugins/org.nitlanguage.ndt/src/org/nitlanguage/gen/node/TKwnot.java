/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.node;

import org.nitlanguage.gen.analysis.*;

@SuppressWarnings("nls")
public final class TKwnot extends Token
{
    public TKwnot()
    {
        super.setText("not");
    }

    public TKwnot(int line, int pos)
    {
        super.setText("not");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TKwnot(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTKwnot(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TKwnot text.");
    }
}