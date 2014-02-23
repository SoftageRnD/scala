#!/usr/bin/gnuplot -persist

set datafile separator ','
set xrange [0:1100000]
set term pngcairo dashed size 2048, 1536

set style line 1 pt 7 lw 2 lc rgb "red" lt 1
set style line 2 pt 7 lw 2 lc rgb "green" lt 3

set output 'out/add.png'
plot 'data' every ::1::10 u 2:7 ls 1 t 'Scala' w lines,\
     'data' every ::1::10 u 2:7:8 ls 2 t 'Scala error' with errorbars,\
     'data' every ::11::20 u 2:7 ls 3 t 'New Scala' w lines,\
     'data' every ::11::20 u 2:7:8 ls 3 t 'New Scala error' with errorbars