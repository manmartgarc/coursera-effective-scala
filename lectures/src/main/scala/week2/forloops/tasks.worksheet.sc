case class Task(name: String, duration: Int, requirements: List[Task])

val csSetup = Task("cs setup", 4, Nil)
val ide = Task("IDE", 3, Nil)
val hack = Task("hack", 8, List(csSetup, ide))
val deploy = Task("deploy", 3, List(hack))

// notice the structural recursion
def maxTotalDuration(tasks: List[Task]): Int =
  tasks match
    case Nil => 0
    case head :: tail =>
      val headDuration = totalDuration(head)
      val tailDuration = maxTotalDuration(tail)
      if headDuration > tailDuration then headDuration
      else tailDuration

def totalDuration(task: Task): Int =
  val requirementsMaxTotalDuration =
    task.duration + maxTotalDuration(task.requirements)
  requirementsMaxTotalDuration
  // val requirementsMaxTotalDuration =
  //   task.requirements.map(totalDuration).maxOption.getOrElse(0)
  // task.duration + requirementsMaxTotalDuration

totalDuration(deploy)
