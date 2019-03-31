/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

/**
 *
 * @author Ale
 */
import Triangle.SyntacticAnalyzer.SourcePosition;

public class LoopDoWhileCommand extends Command {
    
    public LoopDoWhileCommand (Command cAST, Expression eAST, SourcePosition thePosition) {
    super (thePosition);
    E = eAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitLoopDoWhileCommand(this, o);
  }

  public Expression E;
  public Command C;
}
