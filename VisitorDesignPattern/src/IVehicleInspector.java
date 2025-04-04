/*
  The Visitor Design Pattern is one of the more obscure Go4 Design Patterns
  but in some ways is even more powerful than the Strategy or Decorator
  patterns. Each of those patterns has a structural constraint - in the case
  of a Decorator it is quite explicit, as you type-extend something but
  also use an instance of it to add a behavior. And you are type-bound.
  A Strategy pattern is subject to the "interface zoo" problem when you
  attempt to apply multiple behaviors to multiple related types (think I/O).
  Visitor allows you to dynamically add a behavior to an object without
  really knowing what that behavior is - in some ways that sounds unsafe
  (and it could be!) but also quite powerful.
*/
public interface IVehicleInspector {
    /* A vehicle Inspector is supposed to visit
       all the vehicles parked in his shop and
       calculate the cost for each one of them. */
    int visit(Car car);
    int visit(Van van);
    int visit(Motorbike motorbike);
}
