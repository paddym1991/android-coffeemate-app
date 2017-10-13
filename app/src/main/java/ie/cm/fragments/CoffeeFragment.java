package ie.cm.fragments;

import ie.cm.R;
import ie.cm.activities.Base;
import ie.cm.activities.Edit;
import ie.cm.adapters.CoffeeListAdapter;
import ie.cm.models.Coffee;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.ListView;
                                                                              //make sure the class implements the MultiChoiceModeListener interface
public class CoffeeFragment  extends ListFragment implements  OnClickListener, AbsListView.MultiChoiceModeListener
{ 
  public         Base                activity;
  public static  CoffeeListAdapter 	listAdapter;
  public         ListView 			listView;

  public CoffeeFragment() {
    // Required empty public constructor
  }

  public static CoffeeFragment newInstance() {
    CoffeeFragment fragment = new CoffeeFragment();
    return fragment;
  }

@Override
  public void onAttach(Context context)
  {
    super.onAttach(context);
    this.activity = (Base) context;
  }

  /**
   * Create an instance of the custom adapter and associate it with the Fragment
   * @param savedInstanceState
   */
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    listAdapter = new CoffeeListAdapter(getActivity(), this, Base.coffeeList);      //replaced 'activity' with the method 'getActivity()' in parameters because app didn't recognize 'activity'
    setListAdapter (listAdapter);
  }
     
  @Override
  public void onStart()
  {
    super.onStart();
  }

  @Override
  public void onClick(View view)
  {
    if (view.getTag() instanceof Coffee)
    {
      onCoffeeDelete ((Coffee) view.getTag());
    }
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id)
  {
    Bundle activityInfo = new Bundle(); // Creates a new Bundle object
    activityInfo.putInt("coffeeID", v.getId());

    Intent goEdit = new Intent(getActivity(), Edit.class); // Creates a new Intent
    goEdit.putExtras(activityInfo);
    getActivity().startActivity(goEdit); // Launch the Intent
  }

  public void onCoffeeDelete(final Coffee coffee)
  {
    String stringName = coffee.name;
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());       //replaced 'activity' with the method 'getActivity()' in parameters because app didn't recognize 'activity'
    builder.setMessage("Are you sure you want to Delete the \'Coffee\' " + stringName + "?");
    builder.setCancelable(false);

    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface dialog, int id)
      {
        Base.coffeeList.remove(coffee); // remove from our list
        listAdapter.coffeeList.remove(coffee); // update adapters data
        listAdapter.notifyDataSetChanged(); // refresh adapter
      }
    }).setNegativeButton("No", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface dialog, int id)
      {
        dialog.cancel();
      }
    });
    AlertDialog alert = builder.create();
    alert.show();
  }


  /* ************ MultiChoiceModeListener methods (begin) *********** */
  @Override
  public boolean onCreateActionMode(ActionMode actionMode, Menu menu)
  {
    MenuInflater inflater = actionMode.getMenuInflater();
    inflater.inflate(R.menu.delete_list_context, menu);
    return true;
  }

  @Override
  public boolean onPrepareActionMode(ActionMode actionMode, Menu menu)
  {
    return false;
  }

  @Override
  public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem)
  {
    switch (menuItem.getItemId())
    {
      case R.id.menu_item_delete_coffee:
        deleteCoffees(actionMode);
        return true;
      default:
        return false;
    }

  }

  private void deleteCoffees(ActionMode actionMode)
  {
    for (int i = listAdapter.getCount() - 1; i >= 0; i--)
    {
      if (listView.isItemChecked(i))
      {
        Base.coffeeList.remove(listAdapter.getItem(i));
      }
    }
    actionMode.finish();
    listAdapter.notifyDataSetChanged();
  }

  @Override
  public void onDestroyActionMode(ActionMode actionMode)
  {}

  @Override
  public void onItemCheckedStateChanged(ActionMode actionMode, int position, long id, boolean checked)
  {}
  /* ************ MultiChoiceModeListener methods (end) *********** */

}

  