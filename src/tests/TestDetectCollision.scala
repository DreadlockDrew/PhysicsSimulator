package tests
import org.scalatest.FunSuite
import physics.{Boundary, PhysicalObject, PhysicsVector}

class TestDetectCollision extends FunSuite {
 var object1: PhysicalObject = new PhysicalObject(new PhysicsVector(100, 100, 100), new PhysicsVector(3, 5, 2))
 var boundary1: Boundary = new Boundary(new PhysicsVector(10, 10, 0), new PhysicsVector(20, 10, 0))
 var boundary2: Boundary = new Boundary(new PhysicsVector(110,0,0) , new PhysicsVector(110,200,0))


 test("checks") {
  assert(physics.Physics.detectCollision(object1, new PhysicsVector(150, 150, 150), boundary1) == (true), " Hint")
  assert(physics.Physics.detectCollision(object1, new PhysicsVector(150, 150, 150), boundary2) == (false), " Hint")


 }

}
/* package tests
import org.scalatest.FunSuite
import rhymesS.RhymingDictionary

class TestIsRhymeSounds extends FunSuite
{
  test("checks test cases")
  {
    val case1:List[String] = List("D","UW1","P","L","EH2","K","S")
    assert(RhymingDictionary.isRhymeSounds(case4,case1) == (false),"Empty String vs ideal case")
*/




