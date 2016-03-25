package cn.yyx.test.JDTAST;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;

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
		return super.visit(node);
	}
	
	@Override
	public boolean visit(MethodInvocation node) {
		System.out.println("MethodInvocation:" + node);
		ITypeBinding rb = node.getExpression().resolveTypeBinding();
		System.out.println("ITypeBinding:" + rb);
		return super.visit(node);
	}
	
}
