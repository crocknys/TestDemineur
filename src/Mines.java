class Mines {

    static int[][] tabMines(Tableau tableau) {
        int[][] grille = new int[tableau.getHauteur()][tableau.getLargeur()];
        return grille;
    }

    static int[][] minageTerrain(int[][] grille, int nbrMines) {

        for (int a = 0; a < nbrMines; a++) {
            int mineHauteur = (int) (Math.random() * grille.length);
            int mineLargeur = (int) (Math.random() * grille[0].length);

            if (grille[mineHauteur][mineLargeur] != 8) {
                grille[mineHauteur][mineLargeur] = 8;
            }
        }

        return grille;
    }

    static int[][] detecteurMines(int[][] grille) {

        int hauteur = grille.length;
        int largeur = grille[0].length;

        for (int a = 0; a < grille.length; a++) {
            for (int b = 0; b < grille[a].length; b++) {
                int plot = grille[a][b];

                if (plot == 8) {
                    if ((a > 0) && (grille[a - 1][b] != 8)) {
                        grille[a - 1][b] += 1;
                    }
                    if ((a < hauteur - 1) && (grille[a + 1][b] != 8)) {
                        grille[a + 1][b] += 1;
                    }
                    if ((b > 0) && (grille[a][b - 1] != 8)) {
                        grille[a][b - 1] += 1;
                    }
                    if ((b < largeur - 1) && (grille[a][b + 1] != 8)) {
                        grille[a][b + 1] += 1;
                    }
                }
            }
        }

        return grille;
    }

    static void printGrille(int[][] grille) {

        for (int a = 0; a < grille.length; a++) {
            for (int b = 0; b < grille[a].length; b++) {
                System.out.print(grille[a][b]);
            }
            System.out.println();
        }
    }

    static void rendering(int hauteur, int largeur, int nmbrMines) {

        Tableau game = new Tableau(hauteur, largeur);

        int[][] games = Mines.tabMines(game);

        if (nmbrMines > hauteur*largeur - 1){
            nmbrMines = hauteur*largeur-1;
        }

        Mines.minageTerrain(games, nmbrMines);
        Mines.detecteurMines(games);

        System.out.println("Longeur: " + games[0].length);
        System.out.println("hauteur: " + games.length);
        System.out.println("nombre de mines: " + nmbrMines);
        System.out.println(" ");

        Mines.printGrille(games);

    }

}