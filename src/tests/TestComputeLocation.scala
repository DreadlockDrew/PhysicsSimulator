package tests
import org.scalatest.FunSuite
import physics._
import physics.Physics

class TestComputeLocation extends FunSuite{

  var ball = new PhysicalObject(new PhysicsVector(0.0,0.0,100.0),new PhysicsVector(0.0,5.0,-1.0))
  var ball2 = new PhysicalObject(new PhysicsVector(0.0,0.0,5.0),new PhysicsVector(3.0,3.0,-20.0))
  val potentialLoc = physics.Physics.computePotentialLocation(ball,2)
  val finalLocation = new PhysicsVector(0.0,10.0,98.0)

  test("falling forward")
  {
    assert(Physics.computePotentialLocation(ball,2).x == 0.0, "x")
    assert(Physics.computePotentialLocation(ball,2).y == 10.0, "y")
    assert(Physics.computePotentialLocation(ball,2).z == 98.0, "z")
  }

  test("Sticky Floor")
  {
    assert(Physics.computePotentialLocation(ball2,2).x == 6.0, "x")
    assert(Physics.computePotentialLocation(ball2,2).y == 6.0, "y")
    assert(Physics.computePotentialLocation(ball2,2).z == 0.0, "z")

  }

}
