package hw

import chisel3._
import chisel3.util.MuxCase

class Counter(size: Int) extends Module {
  val io = IO(new Bundle {
    val out = Output(UInt(size.W))
    val ena = Input(Bool())
    val clr = Input(Bool())
  })

  val tmp: UInt = RegInit(0.U(size.W))

  when(reset.asBool) {
    tmp := 0.U
  }.otherwise {
    tmp := MuxCase(tmp, Array(io.clr -> 0.U, io.ena -> (tmp + 1.U)))
  }

  io.out := tmp
}
