package com.np.ioc;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

// 注解处理器
public class MyAnnotationProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    // 返回支持注解的类型
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotationTypes = new LinkedHashSet<>();
        annotationTypes.add(MyAnnotation.class.getCanonicalName());
        return annotationTypes;
    }

    // 返回支持注解的源码版本
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("process.......................");
        // 返回通过 @MyAnnotation 注解的元素.
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(MyAnnotation.class);
        for (Element element : elements) {
            System.out.println("++++++++++++++++++++++++++");
            // 判断元素的类型为 Class
            if (element.getKind() == ElementKind.CLASS) {
                // 强转为 TypeElement 类型（代表类）
                TypeElement typeElement = (TypeElement) element;
                System.out.println("被注解的类名：" + typeElement.getSimpleName());
                System.out.println("注解类属性值："
                        + typeElement.getAnnotation(MyAnnotation.class).value());
            }
            System.out.println("++++++++++++++++++++++++++");
        }
        return false;
    }
}
