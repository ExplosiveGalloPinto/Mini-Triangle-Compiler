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

public class CasesDeclaration extends Declaration{
    public CasesDeclaration (CaseDeclaration cdAST,ElseCaseDeclaration edAST,SourcePosition thePosition) {
        super (thePosition);
        cd = cdAST;
        e=edAST;
   
      }

      public Object visit(Visitor v, Object o) {
        return v.visitCasesDeclaration(this, o);
      }

      public CaseDeclaration cd;
      public ElseCaseDeclaration e;
    
}
