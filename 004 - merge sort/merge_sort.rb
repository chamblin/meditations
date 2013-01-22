class MergeSort
  def initialize(items)
    @items = items
  end
  
  def sorted
    if @items.length <= 1
      return @items
    else
      half = (@items.length/2)
      left = MergeSort.new(@items[0..(half-1)]).sorted
      right = MergeSort.new(@items[half..-1]).sorted
      return merge(left, right)
    end
  end
  
  private
    def merge(l1, l2)
      r = []
      i1 = i2 = 0
      while (i1 < l1.length) and (i2 < l2.length)
        if(l1[i1] < l2[i2])
          r << l1[i1]
          i1 += 1 
        else
          r << l2[i2]
          i2 += 1
        end
      end
      r += l1[i1..-1]
      r += l2[i2..-1]
      return r
    end
end

puts "sorted: %s" % MergeSort.new([6,234,123,5,71,4,6,8,1,3,1,1,1,2,3,4,5,0]).sorted.inspect