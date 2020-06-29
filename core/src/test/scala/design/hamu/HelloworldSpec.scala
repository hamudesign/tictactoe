package design.hamu

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class HelloworldSpec extends AnyWordSpec with Matchers {
  "Helloworld" should {
    "produce a greeting" in {
      Helloworld.greeting must equal("Hello world!")
    }
  }
}
