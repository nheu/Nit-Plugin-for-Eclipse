/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import org.nitlanguage.gen.simplec.analysis.*;

public final class TStruct extends Token
{
    public TStruct()
    {
        super.setText("struct");
    }

    public TStruct(int line, int pos)
    {
        super.setText("struct");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TStruct(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTStruct(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TStruct text.");
    }
}
