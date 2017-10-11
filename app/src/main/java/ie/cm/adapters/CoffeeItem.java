package ie.cm.adapters;

import ie.cm.models.Coffee;
import ie.cm.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CoffeeItem {
	View view;

	public CoffeeItem(Context context, ViewGroup parent,
			OnClickListener deleteListener, Coffee coffee) 
	{
		//Inflating the 'Current Row'
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.coffeerow, parent, false);
		view.setId(coffee.coffeeId);			//Setting the 'Rows' id to the Coffee id for Editing

		updateControls(coffee);

		//'Tagging' the Delete Image with a Coffee for Deleting
		ImageView imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
		imgDelete.setTag(coffee);
		imgDelete.setOnClickListener(deleteListener);
	}

	/**
	 * Updating the 'Row' with Coffee Data
	 * @param coffee
	 */
	private void updateControls(Coffee coffee) {
		//"binding" to each of the widgets (Views) on the layout and setting their value. in order to ensure all data is displayed correctly.
		((TextView) view.findViewById(R.id.rowCoffeeName)).setText(coffee.name);
		((TextView) view.findViewById(R.id.rowCoffeeShop)).setText(coffee.shop);
		((TextView) view.findViewById(R.id.rowRating)).setText(coffee.rating + " *");
		((TextView) view.findViewById(R.id.rowPrice)).setText("€" + new DecimalFormat("0.00").format(coffee.price));

		ImageView imgIcon = (ImageView) view.findViewById(R.id.RowImage);
		//set the favourite on/off depending on the coffees favourite value
		if (coffee.favourite == true)
			imgIcon.setImageResource(R.drawable.ic_favourite_on);
		else
			imgIcon.setImageResource(R.drawable.ic_favourite_on);
		
	}
}
