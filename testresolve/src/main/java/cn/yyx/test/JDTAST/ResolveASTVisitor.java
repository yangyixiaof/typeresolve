package cn.yyx.test.JDTAST;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.ArrayInitializer;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.TypeLiteral;

public class ResolveASTVisitor extends ASTVisitor{
	
	@Override
	public boolean visit(MethodDeclaration node) {
		/*List list = node.parameters();
		Iterator<ASTNode> itr = list.iterator();
		while (itr.hasNext())
		{
			ASTNode o = itr.next();
			if (o instanceof SingleVariableDeclaration)
			{
				IVariableBinding bind = ((SingleVariableDeclaration) o).resolveBinding();
				System.out.println("Binding:" + bind);
			}
		}
		System.out.println("MethodDeclaration:" + node);
		IMethodBinding rb = node.resolveBinding();
		System.out.println("ITypeBinding:" + rb);*/
		System.out.println("MethodDeclaration:" + node);
		// System.out.println("MethodDeclarationReturnType:" + node.getReturnType());
		System.out.println("MethodDeclarationReturnType2:" + node.getReturnType2());
		return super.visit(node);
	}
	
	@Override
	public boolean visit(ArrayCreation node) {
		
		return super.visit(node);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean visit(ArrayInitializer node) {
		List<Expression> exps = node.expressions();
		for (Expression exp : exps)
		{
			System.err.println(exp.getClass());
		}
		return super.visit(node);
	}
	
	@Override
	public void endVisit(TypeLiteral node) {
		
		super.endVisit(node);
	}
	
	@Override
	public boolean visit(MethodInvocation node) {
		System.out.println("MethodInvocation:" + node);
		ITypeBinding rb = node.getExpression().resolveTypeBinding();
		System.out.println("ITypeBinding:" + rb);
		return super.visit(node);
	}
	
}
