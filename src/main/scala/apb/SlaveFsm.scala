package crew.chisel.amba.apb

import chisel3._

final class SlaveFsm(p: Config) extends Module {
  val io = IO(new ApbLink(p))
}
