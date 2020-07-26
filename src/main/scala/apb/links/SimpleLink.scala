package crew.chisel.amba.apb

import chisel3._

class SimpleLink(p: Config) extends Bundle {

  // Shared address
  val addr = Input(UInt(p.addrWidth.W))

  // Write channel
  val wen   = Input(Bool())
  val wdata = Input(UInt(p.dataWidth.W))

  // Read channel
  val rdy   = Output(Bool())
  val rdata = Output(UInt(p.dataWidth.W))
}
