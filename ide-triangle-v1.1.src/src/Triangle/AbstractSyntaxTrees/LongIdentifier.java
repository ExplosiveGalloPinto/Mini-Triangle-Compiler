/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Ale
 */

public class LongIdentifier extends Identifier {
    
    public LongIdentifier (Identifier iAST,Identifier i2AST,String theSpelling, SourcePosition thePosition) {
        super (theSpelling, thePosition);
        I = iAST;
        I2 = i2AST;
        
      }

      public Object visit(Visitor v, Object o) {
        return v.visitLongIdentifier(this, o);
      }

      public Identifier I;
      public Identifier I2;
     

}