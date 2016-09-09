package designpattern.decorator;

public class Client {

	public static void main(String[] args) {
		
		System.out.println("==============Draw Cicle================");
		Shape cicle = new CicleShape();
		cicle.draw();
		
		System.out.println("============Draw Rectangle==============");
		Shape rectangle = new RectangleShape();
		rectangle.draw();
		
		System.out.println("============Draw Red Cicle==============");
		Shape redShape = new RedShapeDecorator(cicle);
		redShape.draw();
		
		System.out.println("==========Draw Green Rectangle==========");
		Shape greenShape = new GreenShapeDecorator(rectangle);
		greenShape.draw();
		
	}

}
