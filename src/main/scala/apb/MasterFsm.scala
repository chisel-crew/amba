package crew.chisel.amba.apb

import chisel3._

final class MasterFsm(p: Config) extends Module {
  val io = IO(new ApbLink(p))
}
