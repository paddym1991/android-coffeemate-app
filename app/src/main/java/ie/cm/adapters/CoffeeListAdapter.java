package ie.cm.adapters;

import ie.cm.models.Coffee;
import ie.cm.R;

import java.util.List;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class CoffeeListAdapter extends ArrayAdapter<Coffee> 
{
  private Context context;
  private OnClickListener deleteListener;
  public List<Coffee> coffeeList;

  /**
   * Our constructor, associating our data (our list of Coffees) with the view we want to bing to (coffeerow)
   * @param context
   * @param deleteListener
   * @param coffeeList
   */
  public CoffeeListAdapter(Context context, OnClickListener deleteListener, List<Coffee> coffeeList)
  {                                       //a reference for deleting a coffee
    super(context, R.layout.coffeerow, coffeeList);

    this.context = context;
    this.deleteListener = deleteListener;
    this.coffeeList = coffeeList;
  }

  /**
   * Automatically called for every object that exists in the underlying data (ie coffeeList)
   * @param position
   * @param convertView
   * @param parent
   * @return CoffeeItem reference - a new 'Row' to add to the Parent ViewGroup (theListView)
   */
  @Override
  public View getView(int position, View convertView, ViewGroup parent)
  {
    CoffeeItem item = new CoffeeItem(context, parent, deleteListener, coffeeList.get(position));
    return item.view;
  }

  @Override
  public int getCount()
  {
    return 0;
  }
  
  @Override
  public Coffee getItem(int position)
  {
	  return null;
  }

  @Override
  public long getItemId(int position)
  {
    return 0;
  }

  @Override
  public int getPosition(Coffee c)
  {
    return 0;
  }
}
