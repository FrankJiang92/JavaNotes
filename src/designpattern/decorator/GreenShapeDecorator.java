package designpattern.decorator;

public class GreenShapeDecorator extends ShapeDecorator {

	public GreenShapeDecorator(Shape shape) {
		super(shape);
	}
	
	@Override
	public void draw() {
		shape.draw();
		this.decorator();
	}
	
	private void decorator() {
		System.out.println("------->Add Shape Color : Green");
	}

}
