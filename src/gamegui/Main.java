package gamegui;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import game.*;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException
	{
        State s = new State();
        new Containers(s);
	}

}
