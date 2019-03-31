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

public class ParDeclaration extends Declaration{
    public ParDeclaration (Declaration dAST,Declaration d2AST,SourcePosition thePosition) {
        super (thePosition);
        d = dAST;
        d2=d2AST;
   
      }

      public Object visit(Visitor v, Object o) {
        return v.visitParDeclaration(this, o);
      }

      public Declaration d;
      public Declaration d2;
    
}