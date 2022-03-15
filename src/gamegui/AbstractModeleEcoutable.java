package gamegui;

import java.util.ArrayList;

public abstract class AbstractModeleEcoutable implements EcouteurModele {
	
	private ArrayList<EcouteurModele> ecouteurs;
	
	public AbstractModeleEcoutable()
	{
		ecouteurs = new ArrayList<>();
	}
	
	public void ajoutEcouteur(EcouteurModele e)
	{
		this.ecouteurs.add(e);
	}
	public void retraitEcouteur(EcouteurModele e)
	{
		if (this.ecouteurs.contains(e))
			this.ecouteurs.remove(e);
	}
	protected void fireChangement()
	{
		for (EcouteurModele e : this.ecouteurs)
		{ 
		e.modeleMAJ(this);
		}
	}
}
