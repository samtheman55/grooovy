class SquarePeg {
    def width
}

class RoundPeg {
    def radius
}

class RoundHole {
    def radius
    def pegFits(peg) {
        peg.radius <= radius
    }
    String toString() { "RoundHole with radius $radius" }
}

class SquarePegAdapter extends SquarePeg{
    def getRadius() {
        Math.sqrt(((width / 2) ** 2) * 2)
    }
    String toString() {
        "SquarePegAdapter with peg width $width (and notional radius $radius)"
    }
}

def hole = new RoundHole(radius: 4.0)
(4..7).each { w ->
    def peg = new SquarePegAdapter(width: w)
    if (hole.pegFits(peg)) {
        println "peg $peg fits in hole $hole"
    } else {
        println "peg $peg does not fit in hole $hole"
    }
}
