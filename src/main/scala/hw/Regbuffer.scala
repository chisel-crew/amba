package hw

import chisel3._

class Regbuffer() extends Module {
  val io = IO(new Bundle {
    val din  = Input(Bool())
    val dout = Output(Bool())
  })

  io.dout := RegNext(io.din)
}
