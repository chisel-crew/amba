package crew.chisel.amba.apb

import chisel3._

// Master side signal directions
class ApbLink(p: Config) extends Bundle {

  val paddr   = Output(UInt(p.addrWidth.W))
  val pprot   = Output(UInt(p.protWidth.W))
  val psel    = Output(Bool())
  val penable = Output(Bool())
  val pwrite  = Output(Bool())
  val pwdata  = Output(UInt(p.dataWidth.W))
  val pstrb   = Output(UInt(p.strbWidth.W))

  val pready  = Input(Bool())
  val prdata  = Input(UInt(p.dataWidth.W))
  val pslverr = Input(Bool())

}

object APBBundle {
  def apply(p: Config) = new ApbLink(p)
}
