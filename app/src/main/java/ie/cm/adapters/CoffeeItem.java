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

public class CoffeeItem {
	View view;

	public CoffeeItem(Context context, ViewGroup parent,
			OnClickListener deleteListener, Coffee coffee) 
	{
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.coffeerow, parent, false);
		view.setId(coffee.coffeeId);

		updateControls(coffee);

		ImageView imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
		imgDelete.setTag(coffee);
		imgDelete.setOnClickListener(deleteListener);
	}

	private void updateControls(Coffee coffee) {
		((TextView) view.findViewById(R.id.rowCoffeeName)).setText(coffee.name);
		
		// Do the same for shop, rating, price & the favourite image here
		// and set the favourite on/off depending on the coffees favourite value
		
	}
}
