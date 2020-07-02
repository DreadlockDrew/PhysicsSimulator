package physics
import java.awt.geom.Line2D

import sun.invoke.empty.Empty

object Physics {

  //In the Physics object write a method named computePotentialLocation that takes a
  //PhysicalObject and a Double (delta time) as parameters and returns a PhysicsVector. The
  //returned vector is the location of the object after delta time has passed based on its velocity
  //if there are no boundaries in the way. This method should not allow objects to fall through
  //the ground so if the z position would be negative it should be 0.0 instead. You are not
  //modifying the object’s location in this method since we still need to check for collisions with
  //boundaries to see if this move is valid.
  //In the tests package write a test suite named TestComputeLocation that tests this method.

  def computePotentialLocation(rigidBody:PhysicalObject,DeltaT:Double):PhysicsVector =
  {
    var potentialLocation:PhysicsVector= new PhysicsVector(rigidBody.location.x,rigidBody.location.y,rigidBody.location.z) // X Y Z

    potentialLocation.x=returnScalarDistance(rigidBody.location.x,rigidBody.velocity.x,DeltaT)
    potentialLocation.y=returnScalarDistance(rigidBody.location.y,rigidBody.velocity.y,DeltaT)
    potentialLocation.z=returnScalarDistance(rigidBody.location.z,rigidBody.velocity.z,DeltaT)
    if(potentialLocation.z < 0.0)
      {potentialLocation.z = 0}

    return potentialLocation
  }

///In the Physics object write a method named updateVelocity that takes a PhysicalObject, a
  //World, and a Double (delta time) as parameters and returns Unit. This method will update
  //the object’s velocity based on the acceleration due to gravity of the input world. This
  //acceleration will be a positive value during testing (magnitude only). If the object’s z location
  //is 0.0 (on the ground) and its z velocity is negative (falling) then its z velocity should be set to
  //0.0 to reflect that the falling object has landed on the ground.
  def updateVelocity(Object:PhysicalObject,Planetoid:World,DeltaT:Double):Unit=
{

}

  //In the Physics object write a method named detectCollision that takes a PhysicalObject, a
  //PhysicsVector (potential location for the object), and a Boundary as parameters and returns
  //a Boolean. This method is called when an object is attempting to move to a new location and
  //returns false if that move would collide with the Boundary. Assume that boundaries cannot
  //be crossed regardless of height (ie. ignore the z dimension for this method).
  //Hint: This method is determining if 2 line segments intersect in a 2d space.
  //In the tests package write a test suite named TestDetectCollision that tests this method.

  //USE THE SLOPS OF THE LINE TO COMPUTE THIS
  //SHOULD RETURN FALSE IF A COLISSION IS DETECTED
  def detectCollision(rigidBody:PhysicalObject,bodyPos:PhysicsVector,bound:Boundary):Boolean=
  {
    !Line2D.linesIntersect(rigidBody.location.x,rigidBody.location.y,bodyPos.x,bodyPos.y,bound.start.x,bound.start.y,bound.end.x,bound.end.y)
  }


  def main(args: Array[String]): Unit = {


  }




  def returnVelocity(V_intial:Double,Acceleration:Double = 0.0,DeltaT:Double=0.0):Double=
  {
    val V_Final:Double = V_intial+Acceleration*DeltaT
    V_Final
  }

  def returnScalarDistance(intialD:Double,velocity:Double,DeltaT:Double=0.0):Double=
  {
    val finalD = intialD + velocity * DeltaT
    finalD
  }

}



