package cn.yyx.test.JDTAST;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;

public class ASTMain {

	@SuppressWarnings("unchecked")
	public void ParseOneFileAndVisit(File f) {
		String identifier = f.getName();
		IDocument pdocument = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			StringBuilder content = new StringBuilder();
			String tmp = null;
			while ((tmp = reader.readLine()) != null) {
				content.append(tmp);
				content.append("\n");
			}
			reader.close();
			reader = null;
			String source = content.toString();
			pdocument = new Document(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assert pdocument != null;
		ASTParser parser = ASTParser.newParser(AST.JLS8);
		parser.setBindingsRecovery(true);
		parser.setResolveBindings(true);
		parser.setUnitName(identifier);
		Map<String, String> options = JavaCore.getOptions();
		options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_8); // or newer
																		// version
		parser.setCompilerOptions(options);

		String[] sources = { "D:/Java_RCP_Workspace2/testresolve/src/main/java" };
		String[] classpath = { "C:/Program Files/Java/jdk1.8.0_73/jre/lib/rt.jar", "C:/Users/Administrator.HU7PZ1YCKPVRBDW/.m2/repository/org/eclipse/tycho/org.eclipse.jdt.core/3.11.1.v20150902-1521/org.eclipse.jdt.core-3.11.1.v20150902-1521.jar" };
		parser.setEnvironment(classpath, sources, new String[] { "UTF-8" }, true);
		parser.setSource(pdocument.get().toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		// parser.setKind(ASTParser.K_STATEMENTS);
		// parser.setSource("test.Mett(\"sd\",4);".toCharArray());
		
		// Block block = (Block) parser.createAST(null);
		// block.accept(new ResolveASTVisitor());
		
		CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);
		if (compilationUnit.getAST().hasBindingsRecovery()) {
			System.out.println("Binding activated.");
		} else {
			System.out.println("Binding inactivated.");
		}
		List<AbstractTypeDeclaration> typeDeclarations = compilationUnit.types();
		for (AbstractTypeDeclaration object : typeDeclarations) {
			AbstractTypeDeclaration clazzNode = (AbstractTypeDeclaration) object;
			ResolveASTVisitor fmastv = new ResolveASTVisitor();
			clazzNode.accept(fmastv);
		}
	}

}
