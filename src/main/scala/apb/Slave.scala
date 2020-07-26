package crew.chisel.amba.apb

import chisel3._

final class Slave(p: Config) extends Module {
  val io = IO(new Bundle {
    val io  = new SimpleLink(p)
    val apb = new ApbLink(p)
  })
}
