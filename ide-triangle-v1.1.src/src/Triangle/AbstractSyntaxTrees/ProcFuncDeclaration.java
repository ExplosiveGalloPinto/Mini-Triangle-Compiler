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
public class ProcFuncDeclaration extends Declaration{
    public ProcFuncDeclaration (Declaration dAST, Declaration dAST2, SourcePosition thePosition) {
        super (thePosition);
        I = dAST;
        I2 = dAST2;
      }

      public Object visit(Visitor v, Object o) {
        return v.visitProcFuncDeclaration(this, o);
      }

      public Declaration I;
      public Declaration I2;
}

