package ie.cm.activities;

import ie.cm.R;
import ie.cm.models.Coffee;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;


public class Edit extends Base {
	private Context context;
	private Boolean isFavourite;
	private Coffee aCoffee;
	private ImageView favouriteImage;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = this;

	}

	private Coffee getCoffeeObject(int id) {

		for (Coffee c : coffeeList)
			if (c.coffeeId == id)
				return c;

		return null;
	}

	private int getCoffeeIndex(Coffee obj) {

		for (Coffee c : coffeeList)
			if (c.coffeeId == obj.coffeeId)
				return coffeeList.indexOf(c);

		return -1;
	}

	public void update(View v) {

		String coffeeName = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
		String coffeeShop = ((EditText) findViewById(R.id.shopEditText)).getText().toString();
		String coffeePriceStr = ((EditText) findViewById(R.id.priceEditText)).getText().toString();
		double ratingValue =((RatingBar) findViewById(R.id.coffeeRatingBar)).getRating();
		double coffeePrice;

		try {
			coffeePrice = Double.parseDouble(coffeePriceStr);
		} catch (NumberFormatException e) {
			coffeePrice = 0.0;
		}

		if ((coffeeName.length() > 0) && (coffeeShop.length() > 0) && (coffeePriceStr.length() > 0)) {
			aCoffee.name = coffeeName;
			aCoffee.shop = coffeeShop;
			aCoffee.price = coffeePrice;
			aCoffee.rating = ratingValue;

			// Update coffee & return home

		} else
			toastMessage("You must Enter Something for Name and Shop");

	}
}
