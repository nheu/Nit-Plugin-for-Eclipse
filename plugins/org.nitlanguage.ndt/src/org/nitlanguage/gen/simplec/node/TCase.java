/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.nitlanguage.gen.simplec.node;

import org.nitlanguage.gen.simplec.analysis.*;

public final class TCase extends Token
{
    public TCase()
    {
        super.setText("case");
    }

    public TCase(int line, int pos)
    {
        super.setText("case");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TCase(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCase(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TCase text.");
    }
}