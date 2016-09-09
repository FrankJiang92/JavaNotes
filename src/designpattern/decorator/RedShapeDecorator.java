package designpattern.decorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape shape) {
		super(shape);
	}
	
	@Override
	public void draw() {
		shape.draw();
		this.decorator();
	}

	private void decorator() {
		System.out.println("------->Add Shape Color : Red");
	}
}
