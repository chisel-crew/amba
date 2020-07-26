package crew.chisel.amba.apb

import chisel3._

class MainLink(p: Config) extends Bundle {
  val apb = new ApbLink(p)
  val io  = new SimpleLink(p)
}
