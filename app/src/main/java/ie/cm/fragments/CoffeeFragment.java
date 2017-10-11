package ie.cm.fragments;

import ie.cm.activities.Base;
import ie.cm.adapters.CoffeeListAdapter;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class CoffeeFragment  extends ListFragment implements  OnClickListener
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
  } 
}

  